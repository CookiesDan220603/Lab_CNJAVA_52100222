
window.onload = async () => {
    const data = await getProducts();
    const cate = await getCategories();
    renderCate(cate)
    renderProduct(data)
}

async function getProducts() {
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
function renderProduct(data) {
    const html = data.map(product => {
        return `
            <div class="col-lg-4 col-md-12 mb-4">
                <div class="card">
                    <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                        data-mdb-ripple-color="light">
                        <img src="/images/${product.image}"
                            class="w-100" />
                       
                    </div>
                    <div class="card-body">
                        <a href="/product/${product.id}" class="text-reset">
                            <h5 class="card-title mb-3">${product.name}</h5>
                        </a>
                        <a href="" class="text-reset">
                            <p>${product.nameCategory}</p>
                        </a>
                        <h6 class="mb-3">$${product.price}</h6>
                    </div>
                </div>
            </div>
        `
    }).join(' ')
    const wrapper = document.getElementById('home-wrapper-product')
    wrapper.innerHTML = html
}

const filterCategory = document.getElementById('filter-category')
 function renderCate(data) {
    const html = data.map(category => {
        return `
            <option value="${category.id}">${category.name}</option>
        `
    }).join('')

    filterCategory.innerHTML = html;
 }

async function getCategories() {
    try {
        const response = await fetch("http://localhost:8082/category")
        const res = await response.json();
        
        if(res.statusCode == 0) {
            console.log(res)
            return res.data

        }
    } catch (error) {
        console.log("Loi gì", error)
    }
}

filterCategory.onchange = async () => {
    const id = filterCategory.value;
    console.log(id)
    const data = await getProductsByCategory(id);
    console.log(data)
    renderProduct(data)
}

async function getProductsByCategory(id) {
    try {
        const response = await fetch("http://localhost:8082/product/category/" + id)
        const res = await response.json();
        
        console.log(res)
        if(res.statusCode == 0) {
            return res.data

        }
    } catch (error) {
        console.log("Loi gì", error)
    }
}

const filterBrand = document.getElementById('filter-brand')

filterBrand.onchange = async () => {

    const brand = filterBrand.value;
    try {
        const response = await fetch("http://localhost:8082/product/brand/" + brand)
        const res = await response.json();
        
        
        if(res.statusCode == 0) {
            renderProduct(res.data)
        }
    } catch (error) {
        console.log("Loi gì", error)
    }
}

const filterColor = document.getElementById('filter-color')

filterColor.onchange = async () => {

    const color = filterColor.value;
    try {
        const response = await fetch("http://localhost:8082/product/color/" + color)
        const res = await response.json();
        
        
        if(res.statusCode == 0) {
            renderProduct(res.data)

        }
    } catch (error) {
        console.log("Loi gì", error)
    }
}