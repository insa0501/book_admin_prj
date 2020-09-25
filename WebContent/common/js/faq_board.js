$(document).ready(function () {
    
    $('.ques').click(function(){
        var clicked_q = this.id;
        var selected_a = clicked_q+"_a";

        console.log("id : "+clicked_q +"//"+ selected_a);
        setHidden(selected_a, clicked_q);
    })

}) //ready

function setHidden(selected_a, clicked_q) {
    var answer = document.getElementById(selected_a);
    var selected_title = document.getElementById(clicked_q);

    if( $(answer).hasClass('hidden') ){ //hidden class가 있을 시
        $(answer).removeClass('hidden'); //hidden을 없애고 = 보여줌
        $(selected_title).addClass('selected_title'); //제목을 두껍게
    } else {
        $(answer).addClass('hidden');
        $(selected_title).removeClass('selected_title');
    }
}

