const btnAddProduct = document.querySelector(".btn-add-product");
const category = document.getElementById('idCategory')
const inputName = document.getElementById('name')
const inputPrice = document.getElementById('price')
const inputImage = document.getElementById('image')
const inputColor = document.getElementById('color')
const inputBrand = document.getElementById('brand')


btnAddProduct.addEventListener("click", () => {

    const formData = new FormData();
    const fileImage = inputImage.files[0];

    formData.append("idCategory", Number.parseInt(category.value));
    formData.append("name", inputName.value);
    formData.append("brand",inputBrand.value);
    formData.append("price", Number.parseFloat(inputPrice.value));
    formData.append("image", fileImage);
    formData.append("color", inputColor.value);
   requestAddProduct(formData);
  
});


async function getProduct() {
    try {
        const response = await fetch("http://localhost:8082/product")
        const res = await response.json();
        
        if(res.statusCode == 0) {
            console.log(res)
            return res.data

        }
    } catch (error) {
        console.log("Loi gì", error)
    }
}


async function requestAddProduct(data) {
    const url = "http://localhost:8082/product/add";
    try {
        const response = await fetch(url, {
            method: 'POST',
            body: data
        })

        const res = await response.json();

        if (res.statusCode == 0) {
            console.log(res)
            const data = await getProduct();
            render(data)
        }
       
    } catch(err) {
        console.log(err)
    }    
}

window.onload = async () => {
    const data = await getProduct();
    render(data)
}

function render(data) {
    const html = data.map(product => {
        return `
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><img class="image-product" width="30" height="30" src="/images/${product.image}" /></td>
                <td>${product.color}</td>
                <td>${product.brand}</td>
                <td>
                    <a href="/product/edit/${product.id}" class="edit" ><i class="material-icons" ></i></a>
                    <a href="/product/delete/${product.id}" class="delete"><i class="material-icons" >&#xE872;</i></a>
                </td>
            </tr>
        `
    }).join('')

    const wrapperProduct = document.getElementById('body-wrapper-product')
    wrapperProduct.innerHTML = html;
}