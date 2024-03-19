function login(user, psw) {
    
    if (!user.value || !psw.value) {
        console.error("Por favor, ingrese un nombre de usuario y una contraseña válidos.");
        return;
    }

    // Construir el cuerpo de la solicitud
    const body = new URLSearchParams();
    body.append('user', user.value);
    body.append('psw', psw.value);

    // Enviar la solicitud POST al servidor
    fetch('/login', {
        method: 'POST',
        body: body
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Ocurrió un error al iniciar sesión.');
        }
        return response.text();
    })
    .then(data => {
        document.getElementById("logInMsg").innerHTML = data;
    })
    .catch(error => {
        console.error('Error:', error);
        // Manejar el error, por ejemplo, mostrar un mensaje de error al usuario
    });
}