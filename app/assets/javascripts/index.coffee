#$ ->
#  $.get "/bars", (data) ->
#    $.each data, (index, item) ->
#      $("#bars").append "<li>Bar " + item.name + "</li>"

$ ->
  $.get "/bars", (data) ->
    $.each data, (index, item) ->
      $("#bars").append "<tr><td> " + item.name + "</td></tr>"