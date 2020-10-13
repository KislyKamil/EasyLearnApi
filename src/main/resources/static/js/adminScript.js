



$('.addBook').click(() => {

    let input1 = $('.name').val()
    let input2 = $('.author').val()
    let body = document.getElementById("bookBox");

    if(input1 !== null && input2 !== null) {

        fetch("/adminPanel/addBook?name=" + input1 + "&author="+ input2
        ).then((response) => {
            body.innerHTML= "<div class='alert alert-success'>Book added successfully</div>"

        })

        input1.val("")
        input2.val("")
    }
})

function deleteUser(){

    let id = $('.delete').attr('id');

    let body = document.getElementById("userBox");

    console.log(id);

    fetch("/adminPanel/delete?id=" + id

     ).then(() => {
         body.innerHTML= "";
         body.innerHTML= "<div class='alert alert-success'>User deleted successfully</div>"
     })

};

function showOrders(){

    let id = $('.showOrders').attr('id');

    let body = document.getElementById("modal-body");


    fetch("/adminPanel/findOrders?id=" + id

    ).then((response) => {
        return response.json();
    }).then((response) => {
        let obj = response;
        body.innerHTML = "";

        for (let i=0; i< obj.length; i++){
            let div="<div class='order-item'>";

            div += "<div>"+ obj[i].bookName + "</div><div>"+ obj[i].date +"</div><button class='deleteOrder' onclick='deleteOrder(this.id);' id="+obj[i].orderId+"><i class='material-icons'>check_circle</i></button></br></div>";

            body.innerHTML += div;

        }
    })
}

function deleteOrder(id){

    fetch("/adminPanel/deleteOrder?id=" + id

    ).then((response) => {
        showOrders();
    })
}

