<?php

/**
  * CoitoCare
  * =========
  * Complete solution for sexually active people to provide safety from
  * sexually transmitted disease or infection.
  *
  * @author     Axel Ország-Krisz Dr.
  * @author     Richárd Ádám Vécsey Dr.
  *
  * @copyright  (c) 2021 by Axel Ország-Krisz Dr. and Richárd Ádám Vécsey Dr.
  * @copyright  All rights reserved.
  * @copyright  ATTENTION: This code is not open source.
  *
  * This file contains API user interface code.
  */

header('Content-Type: application/json');
$result = array('error' => array(), 'result' => array());
$now = time();
$initial_start = 1622185140 // May 27, 2021 @ 11:59 PM PT
                            // #GileadHacks4Hiv submission deadline

/**
  * Terminate the execution of the code with error output
  *
  * @param    string $p_text
  *           Text to display as error message.
  */
function finish_with_error(string $p_text) : void {

  global $result;

  $result['error'] = $p_text;
  echo(json_encode($result));
  exit();

}

if (! @include_once './api_core.php') finish_with_error('Internal error.');
if (! isset($_GET['endpoint'])) finish_with_error('No endpoint.');
$endpoint = $_GET['endpoint'];

switch ($endpoint) {

  case 'check_user_exists':

    if (! isset($_GET['user_id'])) finish_with_error('Not enough parameter.');
    check_user_exists($_GET['user_id']);
    break;

  case 'check_device_exists':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['device_id'])))
      finish_with_error('Not enough parameter.');
    check_device_exists($_GET['user_id'], $_GET['device_id']);
    break;

  case 'register_user':

    if (! isset($_GET['user_id'])) finish_with_error('Not enough parameter.');
    if (! check_user_exists_bool($_GET['user_id']))
      register_user($_GET['user_id']);
    else finish_with_error('User already exists.');
    break;

  case 'register_device':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['device_id'])))
      finish_with_error('Not enough parameter.');
    if (! check_device_exists_bool($_GET['user_id'], $_GET['device_id']))
      register_device($_GET['user_id'], $_GET['device_id']);
    else finish_with_error('User-device connection already registered.');
    break;

  case 'update_user':

    if (! isset($_GET['user_id'])) finish_with_error('Not enough parameter.');
    if (check_user_exists_bool($_GET['user_id'])) {

      if (isset($_GET['user_nick'])) $t_nick = $_GET['user_nick'];
      else $t_nick = null;
      if (isset($_GET['user_gender'])) $t_gender = intval($_GET['user_gender']);
      else $t_gender = null;
      if (isset($_GET['user_orientation']))
        $t_orientation = intval($_GET['user_orientation']);
      else $t_orientation = null;

      // TODO: implement photo.
      $t_photo = null;

      update_user($_GET['user_id'], $t_nick, $t_gender, $t_orientation,
                  $t_photo);

    } else finish_with_error('Tried to update a non-existing user.');
    break;

  case 'register_disease':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['disease'])) ||
        (! isset($_GET['created_at'])) ||
        (! isset($_GET['start_date'])))
      finish_with_error('Not enough parameter.');
    if (check_user_exists_bool($_GET['user_id'])) {

      // TODO: implement diease check.
      $t_disease = '';

      $t_created_at = intval($_GET['created_at']);
      if ($t_created_at < $initial_start || $t_created_at >= $now)
        finish_with_error('Invalid creation time is given.');
      $t_start_date = intval($_GET['start_date']);
      if ($t_start_date >= $now)
        finish_with_error('Invalid disease start time is given.');
      register_disease($_GET['user_id'], $t_disease, $t_created_at,
                       $t_start_date);

    } else finish_with_error('Tried to add disease for a non-existing user.');
    break;

  case 'register_match_event':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['event_id'])) ||
        (! isset($_GET['created_at'])) ||
        (! isset($_GET['device_id'])))
      finish_with_error('Not enough parameter.');
    if (check_match_event_is_new($_GET['user_id'], $_GET['event_id'],
                                 $_GET['device_id']))
      register_match_event($_GET['user_id'], $_GET['event_id'],
                           $_GET['device_id']);
    else finish_with_error('Tried to register an existing event ID.');
    break;

  case 'register_match':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['event_id'])) ||
        (! isset($_GET['created_at'])) ||
        (! isset($_GET['device_id'])) ||
        (! isset($_GET['other_user_id'])) ||
        (! isset($_GET['other_user_event_id'])) ||
        (! isset($_GET['other_user_device_id'])))
      finish_with_error('Not enough parameter.');
    if (check_match_event_is_new($_GET['user_id'], $_GET['event_id'],
                                 $_GET['device_id']))
      finish_with_error('Tried to add match to a non-existing event.');
    $t_created_at = intval($_GET['created_at']);
    if ($t_created_at < $initial_start || $t_created_at >= $now)
      finish_with_error('Invalid creation time is given.');
    register_match($_GET['user_id'], $_GET['event_id'], $t_created_at,
                   $_GET['device_id'], $_GET['other_user_id'],
                   $_GET['other_user_event_id'], $_GET['other_user_device_id']);
    break;

  case 'sync':

    if ((! isset($_GET['user_id'])) ||
        (! isset($_GET['device_id'])))
      finish_with_error('Not enough parameter.');
    if (check_device_exists_bool($_GET['user_id'], $_GET['device_id']))
      sync($_GET['user_id'], $_GET['device_id']);
    else finish_with_error('Invalid user-device pair to sync with.');
    break;

  case 'list_diseases':

    list_diseases();
    break;

  case 'list_genders':

    list_genders();
    break;

  case 'list_orientations':

    list_orientations();
    break;

  case 'list_protections':

    list_protections();
    break;

  default:

    finish_with_error('Invalid endpoint.');
    break;

}

echo(json_encode($result));

?>
