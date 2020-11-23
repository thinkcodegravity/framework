<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

STRUT DATA TAG LIBRARY - ACCESS STRUTS ACTION DATA(AVRIABLESS)
WELCOME MR : <s:property value = "firstName" />-<s:property value = "lastName" />
 
STRUT CONTROL TAG LIBRARY - MANIPULATE/NAVIGATE THROUGH STRUT ACTION LIST
<s:iterator value="%{fruits}">    <br>   <s:property />    </s:iterator>

STRUT UI TAG LIBRARY - CODE FOR HTML
<s:textfield name="ProductID" label="Product Id" />


<label> Product Name : </label>
<input type="text" name="productname" >

</html>