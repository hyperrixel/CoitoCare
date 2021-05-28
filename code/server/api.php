<?php

header('Content-Type: application/json');
$result = array('error' => array(), 'result' => array());

function finish_with_error($p_text) {

  global $result;

  $result[] = $p_text;
  echo(json_encode($result));
  exit();

}

if (! isset($_GET['endpoint'])) finish_with_error('No endpoint.');

$endpoint = $_GET['endpoint'];

switch ($endpoint) {
  case 'check_user_exists':

    if (! isset($_GET['user_id'])) finish_with_error('Not enough parameter.');
    # code...
    break;

  case 'check_device_exists':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['device_id']))) finish_with_error('Not enough parameter.');
    # code...
    break;

  case 'register_user':

    if (! isset($_GET['user_id'])) finish_with_error('Not enough parameter.');
    # code...
    break;

  case 'register_device':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['device_id']))) finish_with_error('Not enough parameter.');
    # code...
    break;

  case 'update_user':

    if (! isset($_GET['user_id'])) finish_with_error('Not enough parameter.');
    # Optional parameters: nick_name; gender_id, orientation, photo
    # code...
    break;

  case 'register_disease':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['disease'])) ||
        (! isset($_GET['created_at'])) ||
        (! isset($_GET['start_date']))) finish_with_error('Not enough parameter.');
    # code...
    break;

  case 'register_match_event':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['event_id'])) ||
        (! isset($_GET['created_at'])) ||
        (! isset($_GET['device_id']))) finish_with_error('Not enough parameter.');
    # code...
    break;

  case 'register_match':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['event_id'])) ||
        (! isset($_GET['created_at'])) ||
        (! isset($_GET['device_id'])) ||
        (! isset($_GET['other_user_id'])) ||
        (! isset($_GET['other_user_event_id']))) finish_with_error('Not enough parameter.');
    # code...
    break;

  case 'sync':

    if (! isset($_GET['user_id'])) finish_with_error('Not enough parameter.');
    # code...
    break;

  default:

    finish_with_error('Invalid endpoint.');

    break;
}


echo(json_encode($result));

?>
