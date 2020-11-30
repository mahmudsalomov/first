// function getrole() {
//     axios.get("/getrole").then(function (response) {
//         // console.log(response);
//         if(response.data==="USER"){
//             document.getElementById("kabinet").href="/user";
//             document.getElementById("kabinet").style.display="block";
//         }
//         else {
//             if (response.data==="ADMIN"){
//                 document.getElementById("kabinet").href="/admin";
//                 document.getElementById("kabinet").style.display="block";
//             } else {
//
//             }
//         }
//
//     });
// }
//
// function getusername() {
//     let anonim= "<a href='/login' class=\"btn-success btn mt-5\">Kirish</a>";
//     let user= "<a href='/logout' class=\"btn-success btn mt-5\">Chiqish</a>";
//     axios.get("/getusername").then(function (response) {
//         // console.log(response.data);
//         if (response.data==="anonymousUser"){
//             // document.getElementById("btns").innerHTML=anonim;
//         }
//         else {
//             document.getElementById("btns").innerHTML=user;
//             document.getElementById("name").innerHTML="Xush kelibsiz "+response.data;
//         }
//         // document.getElementById("un").innerHTML=response.data;
//     });
//     getrole();
// }

function getrole() {
    axios.get("/getrole").then(function (response) {
        // console.log(response);
        if(response.data==="USER"){
            document.getElementById("kirish").href="/user";
            document.getElementById("kirish").textContent="Kabinet"
            document.getElementById("chiqish").style.display="";
            // document.getElementById("kabinet").style.display="block";
        }
        else {
            if (response.data==="ADMIN"){
                document.getElementById("chiqish").style.display="";
                document.getElementById("kirish").href="/admin";
                document.getElementById("kirish").textContent="Kabinet"
            } else {
                
                document.getElementById("kirish").href="/login";
                document.getElementById("kirish").textContent="Kirish"
            }
        }

    });
}

// function getusername() {
//     let anonim= "<a href='/login' class=\"btn-success btn mt-5\">Kirish</a>";
//     let user= "<a href='/logout' class=\"btn-success btn mt-5\">Chiqish</a>";
//     axios.get("/getusername").then(function (response) {
//         // console.log(response.data);
//         if (response.data==="anonymousUser"){
//             // document.getElementById("btns").innerHTML=anonim;
//         }
//         else {
//             document.getElementById("btns").innerHTML=user;
//             document.getElementById("name").innerHTML="Xush kelibsiz "+response.data;
//         }
//         // document.getElementById("un").innerHTML=response.data;
//     });
//     getrole();
// }