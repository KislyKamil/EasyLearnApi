$('.search-button').click(function () {
    $(this).parent().toggleClass('open');


    if($(".search open")){
        $(this).off('click');
    }
});





function add() {

    let x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function() {
        x.className = x.className.replace("show", "");
    }, 3000);
}


function reserve(id){

    let userId = $('.userId').text();

      fetch("/reserve/"+ id +"?userId=" +userId

      ).then((response) => {
          return response.json();

      })


}



function noBook(){

    alert("Book is already reserved!")
}




