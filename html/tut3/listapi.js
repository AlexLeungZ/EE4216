/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function addItems(parentList, items) {
    var ele;
    items.forEach(function(txt) {
        ele = document.createElement("li");
        ele.innerText = txt;
        parentList.appendChild(ele);
    });
}

window.onload = function() {
	var addBtn = document.querySelector('#addBtn');
	addBtn.onclick = () => addItems(document.getElementById('parent-list'), document.querySelector('#items').value.split(" "));
	
	var removeBtn = document.querySelector('#removeBtn');
	removeBtn.onclick = () => {
		var list = document.getElementById('parent-list');
		list.removeChild(list.firstElementChild); 
	}
}