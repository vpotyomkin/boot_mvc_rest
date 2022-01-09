function getTableForUser() {
    let table = $('#tableForUser tbody');
    table.empty();

    fetch("http://localhost:8080/api/user/")
        .then(res => res.json())
        .then(user => {
                let userRoles = ''
                for (let i = 0; i < user.roles.length; i++) {
                    userRoles += `${user.roles[i].role} `
                }
                let tableFilling = `$(
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>     
                            <td>${userRoles}</td>
                        </tr>
                )`;
                table.append(tableFilling);
            })
}
getTableForUser()
