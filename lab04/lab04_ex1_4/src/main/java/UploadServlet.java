import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.*;
import java.util.*;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UploadServlet extends HttpServlet {
    @Override
    public void init() {
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Part partAttr = request.getPart("document");
        String nameFile = request.getParameter("fileName");
        if(nameFile.equals("")){
            nameFile = partAttr.getName();
        }
        String[] checkExist  = request.getParameterValues("override");
        InputStream is = partAttr.getInputStream();
        String apsPath = "H:\\Code\\CNJava\\CNJava_LT_TH\\TH\\Lab_CNJAVA_52100222\\lab04\\src\\main\\upload";
        File file = new File(apsPath+"\\" + nameFile);
        List <String> listTypes = List.of(new String[]{"txt", "doc", "docx", "img", "pdf", "rar", "zip"});
        String fileType = partAttr.getSubmittedFileName().split("\\.")[1];
        if(!listTypes.contains(fileType)){
            response.getWriter().print("Unsupported file extension");
            return;
        }
        if (file.exists()){
            if (checkExist==null){
                response.getWriter().print("File already exists");
                return;
            }

        }






        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = is.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            if (checkExist!=null)
                if (Objects.equals(checkExist[0], "True")){
                    response.getWriter().print("File has been overridden");
                    return;
                }
            response.getWriter().print("File uploaded. Click <a href ='file://"+apsPath+"\\"
                    +nameFile+"'>here</a> to visit file");
        }
    }
}