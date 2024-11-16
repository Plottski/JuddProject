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

      $(document).ready(function(){
          $('#formForJudd').submit(function(event) {
            console.log(whatJuddWant);
            event.preventDefault();
            var whatJuddWant = $("#juddWantDis").val();
            //var whatJuddWant = {
              //juddWantStuff: $('#juddWantDis').val()
          //  }
            console.log(whatJuddWant);



            $.ajax({
              url: '/search',
              type: 'POST',
              contentType: 'application/json',
              //data: JSON.stringify(whatJuddWant),
              data: JSON.stringify({
                theData:whatJuddWant
              }),
              dataType: 'json',
              Success: function(response) {
                console.log("Sucess:", response);
              },
              error: function(error) {
                console.error("Error:", error);
              }
            });
          });
    });
    })
  }
