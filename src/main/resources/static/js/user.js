
let result= document.getElementById("result")

function personalData(){
    document.getElementById("root").style.display="block";
    document.getElementById("root1").style.display="none";
    document.getElementById("root2").style.display="none";

}
function personalEdit(){
    document.getElementById("root").style.display="none";
    document.getElementById("root1").style.display="none";
    document.getElementById("root2").style.display="block";
}
function personalReyting(){
    document.getElementById("root").style.display="none";
    document.getElementById("root1").style.display="block";
    document.getElementById("root2").style.display="none";
}

// function resultArea(){
//     result.innerText=codeedit.value;
//     console.log(editor.getValue())
// }