/**
 * Created by Dani on 23/09/16.
 */


$(document).ready(function() {


    if ($('#publish_flag').val() == 'true') {
        setInputsToReadOnly();
    }
});


function setInputsToReadOnly(){

    $('.dataForm').find('input').attr('readonly', true);
    $('.dataForm').find('textarea').attr('readonly', true);
    $('.dataForm').find('select').attr('disabled', true);
    $('.dataForm').find('button').attr('disabled', true);
    $('.dataForm').find('a').attr('preventClick', true)

    $('.always-clickable').attr('disabled', false);
}