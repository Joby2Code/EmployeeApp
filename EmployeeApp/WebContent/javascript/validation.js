/**
 * 
 */

function val1()
{x=0;



if(checkcou())

{
	if(checkad())
	{
x=5;

var r=confirm("Are you sure you want to register a complaint for this orderid ?");
if(r==true){

document.fuser.submit();}
else
document.getElementById("fuser").action ="";

return true;
}
}

else
{
alert("Please provide the mandatory values");
return false;
}

if(x!=5)
{
alert("Please provide the mandatory values");
return false;
}

}




function checkad()
{
var x=document.forms["fuser"]["desc"].value;
if (x==null || x=="")
  {
 document.getElementById('a1').innerHTML="Please Enter Description";
  return false;
}
else
{
document.getElementById('a1').innerHTML="";
return true;}
}



function checkcou()
{
var x=document.getElementById("empName").value;
if( x ==null|| x=="" )
   {
document.getElementById('cu').innerHTML="Missing Employee Name";
      return false;
   }
else
{
document.getElementById('cu').innerHTML="";
return true;}}
