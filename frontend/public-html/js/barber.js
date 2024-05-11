const barbersContainer = document.getElementById("barbers-container");

async function getData() {
    try {
        const response = await fetch("http://localhost:8080/barbers");
    
        if (response.ok) {
            const barbers = await response.json();
            let strs = barbers.map((barber) => {
                return `
                    <div class="barber-card ">
                        <span class="barber-avatar">🩺</span>
                        <h4 class="barber-name">${barber.barbername}</h4>
                        <p><b>Направление: </b><span class="barber-dep">${barber.department.depname}</span></p>
                    </div>`
            })
    
            barbersContainer.innerHTML = strs.join('');
        } else {
            barbersContainer.innerHTML = `<h4 style="color: red;">Не удалось получить данные</h4>`
        }
    } catch (e) {
        console.error(e);
    }
}

getData();