import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet ( name = "image1", value = "/image1")
public class ImageServlet1 extends  HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");
        ServletOutputStream out;
        out = response.getOutputStream();
        URL res = getClass().getClassLoader().getResource("dog.jpg");
        File file;
        try {
            assert res != null;
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String absolutePath = file.getAbsolutePath();
        FileInputStream fin = new FileInputStream(absolutePath);
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        int ch;
        while((ch=bin.read())!=-1)
        {
            // display image
            bout.write(ch);
        }
        bin.close();
        fin.close();
        bout.close();
        out.close();
    }
    public void destroy() {
    }
}
