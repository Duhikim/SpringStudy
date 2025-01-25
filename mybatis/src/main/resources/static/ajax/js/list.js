
// 테이블 헤더를 제외하고 행 초기화 함수
function clearTableRows(table) {

    // tbody의 모든 행 삭제
    const tbody = table.getElementsByTagName('tbody')[0];
    while (tbody.firstChild) {
    tbody.removeChild(tbody.firstChild);
    }
}


function setTable(data) {

    console.log("setTable");

    let table = document.getElementById('listTable');
    clearTableRows(table);

    if (data.length > 0) {

        for (const board of data) {

            let seq = board.seq;
            let title = board.title;
            let user = board.reguser;
            let date = board.regdate;

            const row = table.insertRow();

            let cell = row.insertCell();
            cell.textContent = seq;

            cell = row.insertCell();
            cell.innerHTML = "<a href='/view?seq=" + seq + "'>" + title + "</a>";

            cell = row.insertCell();
            cell.textContent = user;

            cell = row.insertCell();
            cell.textContent = date;

        }
    } else {
            const row = table.insertRow();

            let cell = row.insertCell();
            cell.colSpan = 4;
            cell.textContent = "조회된 정보가 없습니다";
    }

}



const apiUrl = '/api/boards';

// fetch 함수를 사용하여 데이터 가져오기
fetch(apiUrl, {
    method: 'GET' // 사용할 HTTP 메서드 (여기서는 GET을 사용)
})
.then(response => {
  // HTTP 응답 상태를 확인
  if (!response.ok) {
    throw new Error('Network response was not ok');
  }
  // JSON 데이터를 파싱하여 Promise 반환
  return response.json();
})
.then(data => {

  console.log(typeof data === 'object');
  console.log(document.getElementById('listTable'));
  console.log( data);
  console.log( data.length);

  console.log("success");
  // JSON 데이터 사용
  setTable(data);
})
.catch(error => {
  // 오류 처리
  alert(error);
  console.error('Error:', error);
});



