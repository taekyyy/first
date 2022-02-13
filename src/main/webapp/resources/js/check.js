const checkboxes = document.getElementsByName('boardChk')


function selectAll(selectAll) {
   
   checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAll.checked
   })
}



//function selectEach(idx) { 나중에 언젠간 써먹을려고
//   const ob = []
//   let key = 0
//   for (let i = 0; i < checkboxes.length; i++) {
//      if (checkboxes[i].checked == true) {
//         ob[key] = checkboxes[i].value
//         key++
//         console.log(ob)
//      }
//   }
//}
