const btnLogin = document.getElementById('btn-login')
const username = document.getElementById('username')
const password = document.getElementById('password')

btnLogin.addEventListener('click', () => {
    const data = {
        "username": username.value,
        "password": password.value,
    }

    login(data)
})


async function login(data) {
    const url = "http://localhost:8082/login"
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        const res = await response.json();
        console.log(res)

        if(res.statusCode == 0) {
            window.location.href = "/"
        }

        
        console.log(res)
    } catch (error) {
        console.log('Co loi ', error)
        window.location.href = "/login"
    }
}