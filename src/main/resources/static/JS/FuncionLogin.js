document.getElementById('inicioForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const codigo = document.getElementById('codigo').value.trim();
    const contrasena = document.getElementById('contrasena').value.trim();

    if (!codigo || !contrasena) {
        alert("Por favor completa todos los campos.");
        return;
    }

    try {
        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ codigo, contrasena })
        });

        const data = await response.json();

        if (response.ok && data.success) {
            alert(data.message || "Inicio de sesión exitoso");
            window.location.href = "menu";
        } else {
            alert(data.message || "Código o contraseña incorrectos.");
        }
    } catch (error) {
        console.error('Error al conectar con el servidor:', error);
        alert('No se pudo conectar con el servidor. Intenta de nuevo más tarde.');
    }
});
