$ ->
  $.get "/list", (data) ->
    $.each data, (index, item) ->
      $("#players").append "<tr><td> " + item.name + "</td>" + "<td>" + item.wins + "</td>" + "<td> " + item.games + "</td>" + "<td>" + ((item.wins/item.games)*100).toFixed(2) + "%" + "</td></tr>"