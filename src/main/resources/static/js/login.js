
$.ajax({
    type: 'POST',
    url: 'user/login/{account}/{password}',
    dataType:'json',
    data:{
        "account":$("#acct").val(),
        "password":$("#pwd").val()
    },
    success: function(data){
        alert(data);
    },
    error:function(){
        alert('error');
    }
});