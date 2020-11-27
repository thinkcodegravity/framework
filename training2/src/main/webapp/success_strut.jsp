<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

STRUT DATA TAG LIBRARY - ACCESS STRUTS ACTION DATA(AVRIABLESS)<br>
WELCOME MR : <s:property value = "firstName" />-<s:property value = "lastName" /><br>
 <br>
STRUT CONTROL TAG LIBRARY - MANIPULATE/NAVIGATE THROUGH STRUT ACTION LIST<br>
<s:iterator value="%{fruits}">    <br>   <s:property />    </s:iterator>
<br>
STRUT UI TAG LIBRARY - CODE FOR HTML<br>
<s:textfield name="ProductID" label="Product Id" />


<label> Product Name : </label>
<input type="text" name="productname" >

</html>