const allNumbers = document.querySelectorAll('.number-quantity')

allNumbers.forEach(number => {
    number.addEventListener('change', () => {
        let id = number.getAttribute("id").substring(1)
        let quantity = number.value

        const data = {
            id, quantity
        }

        updateProductIntoCart(data, id)
    })
})


async function updateProductIntoCart(data, id) {
    const url = "http://localhost:8082/cart/update/" + id;

    try {
        const response = await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })

        const res = await response.json();
        console.log(res)
        window.location.href = "/cart"
    } catch (error) {
        console.log('Co loi ', error)
    }
}

