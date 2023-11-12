const navLinks = document.getElementById('nav-links')

window.onload = async () => {
    const data = await getCategories();

    render(data)
}

function render(data) {
    console.log(data)
    const html = data.map(item => {
        return `
            <a class="p-2 text-dark" href="/category/${item.id}">${item.name}</a>
        `
    }).join('')

    navLinks.innerHTML = html
}

async function getCategories() {
    const url = "http://localhost:8082/category"
    try {
        const response = await fetch(url)

        const res = await response.json();

        if(res.statusCode == 0) {
            return res.data
        }
    } catch (error) {
        
    }
}