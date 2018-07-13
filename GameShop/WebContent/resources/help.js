/**
 * call when login or logout
 * changes active to deactive so the visibility swaps
 */
function changeMyUserMenu() 
{
    var deactives = document.getElementsByClassName("deactive");
    var actives = document.getElementsByClassName("active");
    for(i=0; i<deactives.length; i++) 
    {
    	alert("ich wurde gefunden ");
    	deactives[i].className = "active";
    }
    for(i=0; i<deactives.length; i++) 
    {
    	active[i].className = "deactive";
    }
}

function logout()
{
    changeMyUserMenu();
    alert("halt ");
	document.getElementsById("logoutAction").click();
}


