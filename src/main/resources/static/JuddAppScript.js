//mainContainer.innerHTML="";
  //theButton.addEventListener("onclick", spaFunction)
  function myFunction() {
      console.log("Button clicked!")
  }

  window.onload = function() {
    const mainContainer = document.getElementById("mainContainer");
    var theButton = document.getElementById("spaEnabler");
    theButton.addEventListener("click", spaFunction);
  }

  function spaFunction() {
    console.log("Success");
    var gSearchBar = document.getElementById("googleSearch");
    var theButton = document.getElementById("spaEnabler");
    gSearchBar.parentNode.removeChild(googleSearch);
    theButton.parentNode.removeChild(theButton);

    var juddForm = document.createElement("form");
    juddForm.id = "formForJudd";

    var juddWant = document.createElement("input");
    juddWant.type = "submit";
    juddWant.id = "juddGet";
    juddWant.placeholder = "Judd Get!!!!";

    var juddSearchBar = document.createElement("input");
    juddSearchBar.type = "text";
    juddSearchBar.id = "juddWantDis";
    juddSearchBar.placeholder = "What Judd Want?????";


    juddForm.append(juddSearchBar);
    juddForm.append(juddWant);

    mainContainer.append(juddForm);

    juddForm.addEventListener('submit', (event) => {
      event.preventDefault();

          $('#formForJudd').submit(function(event) {
            console.log(whatJuddWant);
            //event.preventDefault();
            var whatJuddWant = $("#juddWantDis").val();
            //var whatJuddWant = {
              //juddWantStuff: $('#juddWantDis').val()
          //  }
            console.log(whatJuddWant);



            $.ajax({
              url: '/search',
              type: 'POST',
              contentType: 'application/json',
              //data:whatJuddWant.val(),
              //data: JSON.stringify(whatJuddWant),
              //data: {
                //theData:whatJuddWant
              //},
              //data: JSON.stringify({
                //theData:whatJuddWant
             // }),
             data:whatJuddWant,
              Success: function(data) {
                var msg = JSON.parse(data);
                console.log(msg);
                doThings(msg);
                //doThings(data);
                //console.log(handleFormData);
                //var serverData = []
                //serverData = JSON.parse(respons);
                //console.log("Success:", serverData);
                //return serverData;
                //if response.status === 200 {
                  //var data = response;
                  //var parsedJson = JSON.parse(data);
                //  console.log(data);
                  //console.log(parsedJson);
              },
              error: function(error) {
                console.error("Error:", error);
              }
            });
          });
    });

    $(document).ajaxComplete(function(serverData) {
      doThings(serverData);
    });

  //  $.post('/search', function(data) {
    //  var serverData = [];
      //  serverData = data;
      //  console.log(data);
    //});
  }

  function doThings(msg) {
    console.log(msg);
  }
