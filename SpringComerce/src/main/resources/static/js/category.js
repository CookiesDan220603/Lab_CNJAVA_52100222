const inputName = document.getElementById('name-cate-add')
const btnSubmit = document.querySelector('.btn-submit-add')
const wrapperCategory = document.getElementById('body-wrapper-category')

btnSubmit.addEventListener('click', () => {
    const data = {
        "name": inputName.value
    }

    addCategory(data)
})


async function addCategory(data) {
    const url = "http://localhost:8082/category/add"

    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })

        const res = await response.json();

        if(res.statusCode == 0) {
            data = await getCategory()
            render(data)
        }
    } catch (error) {
        
    }
}

window.onload = async () => {
    data = await getCategory()

    render(data)
}

async function getCategory() {
    try {
        const response = await fetch("http://localhost:8082/category")
        const res = await response.json();
        
        if(res.statusCode == 0) {
            console.log(res)
            return res.data

        }
    } catch (error) {
        
    }
}

function render(data) {
    const html = data.map(category => {
        return `
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>
                    <a href="/category/edit/${category.id}" class="edit"><i class="material-icons" ></i></a>
                    <a href="/category/delete/${category.id}" class="delete" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                </td>
            </tr>
        `
    }).join('')

    wrapperCategory.innerHTML = html
}