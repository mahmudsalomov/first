
function add() {
    let username=document.getElementById("username").value;
    let password=document.getElementById("password").value;
    let email=document.getElementById("email").value;
    let phone=document.getElementById("phone").value;

    if (username===""||password===""){
        document.getElementById("error").textContent="Username va password bo'sh bo'lmasligi kerak!";
    }
    else {
        let data={
            username: username,
            password: password,
            email: email,
            phone: phone
        };
        axios.post("/admin/api/add", data)
            .then(function (response) {
                if (response.data==="Error"){
                    console.log(response);
                    document.getElementById("error").textContent="username oldindan mavjud!";
                } else {
                    console.log(response);
                    window.location="/admin/all";
                }
            })
    }


}

function getEdit(id) {
    let p="<div class=\"row text-center d-flex justify-content-center mt-5\">\n" +
        "        <h3 class=\"col-md-8 mt-5\">User ma'lumotlarini tahrirlash</h3>\n" +
        "        <input class=\"form-control col-md-8 mt-3\" name=\"username\" id=\"username\" type=\"text\" placeholder=\"username\">\n" +
        "        <input class=\"form-control col-md-8 mt-3\" name=\"password\" id=\"password\" type=\"text\" placeholder=\"password\">\n" +
        "        <input class=\"form-control col-md-8 mt-3\" name=\"email\" id=\"email\" type=\"email\" placeholder=\"email\">\n" +
        "        <input class=\"form-control col-md-8 mt-3\" name=\"phone\" id=\"phone\" type=\"text\" placeholder=\"phone\">\n" +
        "        <button class=\"btn btn-success col-md-8 mt-3\" type=\"submit\">Saqlash</button>\n" +
        "\n" +
        "</div>";

    let out="";
    axios.get("/admin/api/one", {params: {id:id} })
        .then(function (response) {
            let data=JSON.parse(JSON.stringify(response.data));
            out="<div class=\"row text-center d-flex justify-content-center\">\n" +
                "        <p class=\"col-md-8\" id='error'></p>\n" +
                "        <h3 class=\"col-md-8 mt-5\">User ma'lumotlarini tahrirlash</h3>\n" +
                "        <input type='hidden' id="+data.id+">\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"username\" id=\"username\" type=\"text\" placeholder=\"username\"  value='"+data.username+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"password\" id=\"password\" type=\"text\" placeholder=\"password\">\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"email\" id=\"email\" type=\"email\" placeholder=\"email\"  value='"+data.email+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"phone\" id=\"phone\" type=\"text\" placeholder=\"phone\"  value='"+data.phone+"'>\n" +
                "        <button onclick='edit(this.value)' class=\"btn btn-success col-md-8 mt-3\" type=\"submit\" value="+data.id+">Saqlash</button>\n" +
                "        <a href='/admin/all' class=\"btn btn-success col-md-8 mt-3\" type=\"submit\">Qaytish</a>\n" +
                "\n" +
                "</div>";
            console.log(response);
            document.getElementById("root").innerHTML=out;
        })

}


function edit(id) {
    let username=document.getElementById("username").value;
    let password=document.getElementById("password").value;
    let email=document.getElementById("email").value;
    let phone=document.getElementById("phone").value;

    if (username===""||password===""){
        document.getElementById("error").textContent="Username va password bo'sh bo'lmasligi kerak!";
    }
    else {
        let data={
            id:id,
            username: username,
            password: password,
            email: email,
            phone: phone
        };
        axios.post("/admin/api/edit", data)
            .then(function (response) {
                if (response.data==="Error"){
                    console.log(response);
                    document.getElementById("error").textContent="username oldindan mavjud!";
                } else {
                    console.log(response);
                    window.location="/admin/all";
                }
            })
    }
}