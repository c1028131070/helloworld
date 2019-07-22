$(document).ready(function () {
  //点击搜索
  $("#search").click(function(){
    clickSearch();
  })

  $(document).keydown(function(event){
    if(event.keyCode ==13){
      clickSearch();
    }
  });

  function clickSearch() {
    var keyword = $("#keyword").val();
    window.location.href="http://10.205.130.38:8201/result?key="+encodeURI(keyword);
  }
})