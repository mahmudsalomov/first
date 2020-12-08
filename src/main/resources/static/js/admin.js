
function add() {
    let username=document.getElementById("username").value;
    let password=document.getElementById("password").value;
    let firstname=document.getElementById("firstname").value;
    let lastname=document.getElementById("lastname").value;
    let email=document.getElementById("email").value;
    let phone=document.getElementById("phone").value;
    let groupName=document.getElementById("groupName").value;

    if (username===""||password===""){
        document.getElementById("error").textContent="Username va password bo'sh bo'lmasligi kerak!";
    }
    else {
        let data={
            username: username,
            password: password,
            firstname: firstname,
            lastname: lastname,
            rating: 0,
            email: email,
            phone: phone,
            groupName: groupName
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
                "        <input class=\"form-control col-md-8 mt-3\" name=\"firstname\" id=\"firstname\" type=\"text\" placeholder=\"firstname\"  value='"+data.firstname+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"lastname\" id=\"lastname\" type=\"text\" placeholder=\"lastname\"  value='"+data.lastname+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"rating\" id=\"rating\" type=\"number\" placeholder=\"rating\"  value='"+data.rating+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"email\" id=\"email\" type=\"email\" placeholder=\"email\"  value='"+data.email+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"phone\" id=\"phone\" type=\"text\" placeholder=\"phone\"  value='"+data.phone+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"group\" id=\"groupName\" type=\"text\" placeholder=\"groupName\"  value='"+data.groupName+"'>\n" +
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
    let firstname=document.getElementById("firstname").value;
    let lastname=document.getElementById("lastname").value;
    let rating=document.getElementById("rating").value;
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
            firstname: firstname,
            lastname: lastname,
            rating: rating,
            email: email,
            phone: phone
        };
        axios.put("/admin/api/edit", data)
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











function addPTask() {
    let username=document.getElementById("username").value;
    let title=document.getElementById("title").value;
    let rank=document.getElementById("rank").value;
    let stdin=document.getElementById("stdin").value;
    let answer=document.getElementById("answer").value;

    let permission=document.getElementById("permission").checked;
    // if ()
    // permission = document.getElementById("permission").value === "checked";

    let question=document.getElementById("text").value;
    // let phone=document.getElementById("phone").value;

    if (username===""||title===""||question===""){
        document.getElementById("error").textContent="Username va title bo'sh bo'lmasligi kerak!";
    }
    else {
        let data={
            username: username,
            title: title,
            question: question,
            rank: rank,
            permission: permission,
            attempt: 3,
            stdin: stdin,
            answer: answer,
            lastResult: null,
            lastCode: null,
            solve: false
        };

        axios.post("/admin/api/task/add", data)
            .then(function (response) {
                if (response.data==="Error"){
                    console.log(response);
                    document.getElementById("error").textContent="Error";
                } else {
                    console.log(response);
                    window.location="/admin/task/all";
                }
            })
    }
}

function getEditPTask(id) {
    let out="";
    axios.get("/admin/api/task/one", {params: {id:id} })
        .then(function (response) {
            let data=JSON.parse(JSON.stringify(response.data));
            out="<div class=\"row text-center d-flex justify-content-center mt-3\">\n" +
                "        <p class=\"col-md-8\" id=\"error\"></p>\n" +
                "        <h3 class=\"col-md-8\">Maxsus vazifa qo'shish</h3>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"username\" id=\"username\" type=\"text\" placeholder=\"username\" value='"+data.username+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"title\" id=\"title\" type=\"text\" placeholder=\"title\" value='"+data.title+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"rank\" id=\"rank\" type=\"number\" placeholder=\"rank\" value='"+data.rank+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"attempt\" id=\"attempt\" type=\"number\" placeholder=\"attempt\" value='"+data.attempt+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"permission\" id=\"permission\" type=\"checkbox\" placeholder=\"permission\">\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"stdin\" id=\"stdin\" type=\"text\" placeholder=\"stdin\" value='"+data.stdin+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"answer\" id=\"answer\" type=\"text\" placeholder=\"answer\" value='"+data.answer+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"lastResult\" id=\"lastResult\" type=\"text\" placeholder=\"lastResult\" value='"+data.lastResult+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"lastCode\" id=\"lastCode\" type=\"text\" placeholder=\"lastCode\" value='"+data.lastCode+"'>\n" +
                "        <input class=\"form-control col-md-8 mt-3\" name=\"solve\" id=\"solve\" type=\"text\" placeholder=\"solve\" value='"+data.solve+"'>\n" +
                "\n" +
                "        <textarea class=\"text col-12 mt-2\" placeholder=\"text\" name=\"text\" id=\"text\">\n" +
                "        "+data.question+"" +
                "        </textarea>\n" +
                "\n" +
                "        <button onclick=\"editPTask(this.value)\" class=\"btn btn-success col-md-8 mt-3\" type=\"submit\" value='"+data.id+"'>Qo'shish</button>\n" +
                "\n" +
                "    </div>";
            // document.getElementById("text").textContent=data.text;
            console.log(response);
            document.getElementById("root").innerHTML=out;
        })
}

function editPTask(id) {
    let username=document.getElementById("username").value;
    let title=document.getElementById("title").value;
    let rank=document.getElementById("rank").value;
    let attempt=document.getElementById("attempt").value;
    let stdin=document.getElementById("stdin").value;
    let answer=document.getElementById("answer").value;

    let permission=document.getElementById("permission").checked;
    let lastResult=document.getElementById("lastResult").value;
    let lastCode=document.getElementById("lastCode").value;
    let solve=document.getElementById("solve").value;
    // if ()
    // permission = document.getElementById("permission").value === "checked";

    let question=document.getElementById("text").value;
    // let phone=document.getElementById("phone").value;

    if (username===""||title===""||question===""){
        document.getElementById("error").textContent="Username va title bo'sh bo'lmasligi kerak!";
    }
    else {
        let data={
            id:id,
            username: username,
            title: title,
            question: question,
            rank: rank,
            permission: permission,
            attempt: attempt,
            stdin: stdin,
            answer: answer,
            lastResult: lastResult,
            lastCode: lastCode,
            solve: solve
        };

        axios.put("/admin/api/task/edit", data)
            .then(function (response) {
                if (response.data==="Error"){
                    console.log(response);
                    document.getElementById("error").textContent="Error";
                } else {
                    console.log(response);
                    window.location="/admin/task/all";
                }
            })
    }
}