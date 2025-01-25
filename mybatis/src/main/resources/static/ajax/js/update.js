
// 리스너 등록
    // 목록
    const listButton = document.getElementById('listBtn');
    listButton.addEventListener('click', handleListButtonClick);

    // 수정
    const updateButton = document.getElementById('updateBtn');
    updateButton.addEventListener('click', handleUpdateButtonClick);

function setUpdate(data) {

    document.getElementById("date").innerHTML = data.regdate;
    document.getElementById("user").innerHTML = data.reguser;

    document.getElementById("title").value = data.title;
    document.getElementById("contents").value = data.contents;
    document.getElementById("seq").value = data.seq;


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

function handleUpdateButtonClick() {


    const jsonData = {
        seq: document.getElementById("seq").value,
        title: document.getElementById("title").value,
        contents: document.getElementById("contents").value
    };

    const apiUrl = '/api/board';

    fetch(apiUrl, {
        method: 'PUT', // 사용할 HTTP 메서드
        headers: {
             'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
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
        alert("수정되었습니다.");
        window.location.href = '/update?seq=' + data.seq;
      })
      .catch(error => {
        // 오류 처리
        alert(error);
        console.error('Error:', error);
      });

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
  setUpdate(data);
})
.catch(error => {
  // 오류 처리
  alert(error);
  console.error('Error:', error);
});

