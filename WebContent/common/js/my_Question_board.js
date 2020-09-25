$(document).ready(function () {
    
    $('.ques').click(function(){
        var clicked_q = this.id;
        var selected_con = clicked_q+"_con";
        var selected_a = clicked_q+"_a";

        // console.log("id : "+clicked_q +"//"+ selected_a +"//"+ selected_con);
        setHidden(clicked_q, selected_a, selected_con);
    })

}) //ready

function setHidden(clicked_q, selected_a, selected_con) {
    var answer = document.getElementById(selected_a);
    var selected_title = document.getElementById(clicked_q);
    var selected_content = document.getElementById(selected_con);

    if( $(answer).hasClass('hidden') ){ //hidden class가 있을 시
        $(answer).removeClass('hidden'); //hidden을 없애고 = 보여줌
        $(selected_content).removeClass('hidden'); //hidden을 없애고 = 보여줌
        $(selected_title).addClass('selected_title'); //제목을 두껍게
    } else {
        $(answer).addClass('hidden');
        $(selected_content).addClass('hidden');
        $(selected_title).removeClass('selected_title');
    }
}

