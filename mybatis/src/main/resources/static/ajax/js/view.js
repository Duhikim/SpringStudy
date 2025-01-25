
//이벤트 리스너 등록
// 목록
const listButton = document.getElementById('listBtn');
listButton.addEventListener('click', handleListButtonClick);

// 수정
const updateButton = document.getElementById('updateBtn');
updateButton.addEventListener('click', handleUpdateButtonClick);

// 삭제
const deleteButton = document.getElementById('deleteBtn');
deleteButton.addEventListener('click', handleDeleteButtonClick);

function setView(data) {

    document.getElementById("title").innerHTML = data.title;
    document.getElementById("date").innerHTML = data.regdate;
    document.getElementById("user").innerHTML = data.reguser;
    document.getElementById("contents").innerHTML = data.contents;

}

function getParam(paramName){

    // 현재 페이지의 URL 가져오기
    const currentUrl = window.location.href;

    // URL에서 매개변수 추출하기
    function getParameterValue(parameterName) {
      const urlSearchParams = new URLSearchParams(window.location.search);
      return urlSearchParams.get(parameterName);
    }

    // "seq" 매개변수 값 가져오기
    return getParameterValue(paramName);

}

// 버튼 클릭 이벤트 처리 함수
function handleDeleteButtonClick() {

  const apiUrl = '/api/board/' + getParam("seq");

    fetch(apiUrl, {
        method: 'DELETE' // 사용할 HTTP 메서드 (여기서는 GET을 사용)
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
        console.log("success");
        // JSON 데이터 사용
        alert("삭제에 성공하였습니다.");
        window.location.href = '/list';
      })
      .catch(error => {
        // 오류 처리
        alert(error);
        console.error('Error:', error);
      });

}

function handleUpdateButtonClick() {
window.location.href = '/update?seq=' + getParam("seq");
}

function handleListButtonClick() {
    window.location.href = '/list';
}

const apiUrl = '/api/board/' + getParam("seq");

fetch(apiUrl)
.then(response => {
  // HTTP 응답 상태를 확인
  if (!response.ok) {
    throw new Error('Network response was not ok');
  }
  // JSON 데이터를 파싱하여 Promise 반환
  return response.json();
})
.then(data => {
  console.log("success");
  // JSON 데이터 사용
  setView(data);
})
.catch(error => {
  // 오류 처리
  alert(error);
  console.error('Error:', error);
});


