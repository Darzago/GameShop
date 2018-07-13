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
    	deactives[i].className = "active";
    }
    for(i=0; i<deactives.length; i++) 
    {
    	active[i].className = "deactive";
    }
}

function logout()
{
	alert("suck diclks");
	console.log("piemel");
	document.getElementsById("logoutAction").click();
    changeMyUserMenu();
}


