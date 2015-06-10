$ ->
  $.get "/bars", (data) ->
    $.each data, (index, item) ->
      $("#bars").append "<tr><td> " + item.name + "</td>" + "<td>" + item.wins + "</td>" + "<td> " + item.games + "</td></tr>"