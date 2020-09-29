window.onload = function () {
  var res_str = document.getElementById("res_str");
  var btn_group = document.getElementById("btn_group");
  var res_cancel = document.getElementById("cancel");
  var res_content = document.getElementById("res_content");

  res_str.onclick = function () {
    res_content.style.display = "block";
    btn_group.style.display = "none";
  };

  res_cancel.onclick = function () {
    res_content.style.display = "none";
    btn_group.style.display = "flex";
  };
};
