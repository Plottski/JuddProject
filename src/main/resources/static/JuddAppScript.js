
  window.onload = function() {
    const mainContainer = document.getElementById("mainContainer");
    var theButton = document.getElementById("spaEnabler");
    theButton.addEventListener("click", spaFunction);
  }

  function spaFunction() {
    console.log("spaFunction()...  Deleting existing elements");
    var gSearchBar = document.getElementById("googleSearch");
    var theButton = document.getElementById("spaEnabler");
    gSearchBar.parentNode.removeChild(googleSearch);
    theButton.parentNode.removeChild(theButton);
    console.log("spaFunction()...  elements deleted");

    console.log("spaFunction()...  creating new elements");
    var button = document.createElement("button");
    button.type = "button";
    button.id = "button";
    button.innerHTML = "button text";
    var juddSearchBar = document.createElement("input");
    juddSearchBar.type = "text";
    juddSearchBar.id = "juddWantDis";
    juddSearchBar.placeholder = "What Judd Want?????";
    mainContainer.append(juddSearchBar);
    mainContainer.append(button);
    console.log("spaFunction()...  elements created");

      $('#button').click(function() {
          var whatJuddWant = $("#juddWantDis").val();
          callServer(whatJuddWant)
      });
  }

function callServer(whatJuddWant) {
    console.log("spaFunction()...  Deleting existing elements");
    console.log("callServer(): "+whatJuddWant);

    $.ajax({
        url: "/search",
        method: "POST",
        data: whatJuddWant,
        success: function(data) {
            var msg = JSON.parse(data);
            console.log(msg);
            const brElement = document.createElement("br");
            for(var i = 0; i<msg.items.length; i++){
                mainContainer.append(msg.items[i].title);
                mainContainer.append(msg.items[i].htmlTitle);
            }
        },
        error : function(request,error){
            alert("Request: "+request);
        }
    });
}