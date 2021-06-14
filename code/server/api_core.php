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

/**
  * Check whether a user and device conncetion exist or not
  * =======================================================
  *
  * @param  string $p_user_id
  *         The ID of the user to check.
  * @param  string $p_device_id
  *         The ID of the device to check.
  */
function check_device_exists(string $p_user_id, string $p_device_id) : void {

  global $result;

  $t_result = run_sql("");

  if (count($t_result) == 0) $result['result'] = 'No.';
  else if (count($t_result) == 1) $result['result'] = 'Yes.';
  else finish_with_error('Too many results.');

}

/**
  * Check whether a user and device conncetion exist or not
  * =======================================================
  *
  * @param  string $p_user_id
  *         The ID of the user to check.
  * @param  string $p_device_id
  *         The ID of the device to check.
  *
  * @return bool
  *         True if the user-device connection exists, False if not.
  */
function check_device_exists_bool(string $p_user_id,
                                  string $p_device_id) : bool {

  $t_result = run_sql("");

  if (count($t_result) == 1) return true;
  else return false;

}

/**
  * Check whether an event ID is new for a user on a device
  * =======================================================
  *
  * @param  string $p_user_id
  *         The ID of the user to check for.
  * @param  string $p_event_id
  *         The ID of the event to check.
  * @param  string $p_device_id
  *         The ID of the device to check for.
  */
function check_match_event_is_new(string $p_user_id, string $p_event_id,
                                  string $p_event_id) : bool {

  $t_result = run_sql("");
  if (count($t_result) == 0) return true;
  else return false;

}

/**
  * Check whether a user exist or not
  * =================================
  *
  * @param  string $p_user_id
  *         The ID of the user to check.
  */
function check_user_exists(string $p_user_id) : void {

  global $result;

  $t_result = run_sql("");

  if (count($t_result) == 0) $result['result'] = 'No.';
  else if (count($t_result) == 1) $result['result'] = 'Yes.';
  else finish_with_error('Too many users.');

}

/**
  * Check whether a user exist or not
  * =================================
  *
  * @param  string $p_user_id
  *         The ID of the user to check.
  *
  * @return bool
  *         True if user exists, False if not.
  */
function check_user_exists_bool(string $p_user_id) : bool {

  $t_result = run_sql("");

  if (count($t_result) == 1) return true;
  else return false;

}

/**
  * Quiery list of supported disease types
  * ======================================
  */
function list_diseases() : void {

  global $result;

  $t_result = run_sql("");
  $result['result'] = $t_result;

}

/**
  * Quiery list of supported gender types
  * =====================================
  */
function list_genders() : void {

  global $result;

  $t_result = run_sql("");
  $result['result'] = $t_result;

}

/**
  * Quiery list of supported orientation types
  * ==========================================
  */
function list_orientations() : void {

  global $result;

  $t_result = run_sql("");
  $result['result'] = $t_result;

}

/**
  * Quiery list of supported protection types
  * =========================================
  */
function list_protections() : void {

  global $result;

  $t_result = run_sql("");
  $result['result'] = $t_result;

}

/**
  * Register a user-device connection
  * =================================
  *
  * @param  string $p_user_id
  *         The ID of the user to register.
  * @param  string $p_device_id
  *         The ID of the device to register.
  */
function register_device(string $p_user_id, string $p_device_id) : string {

  global $result;

  run_sql("", false);
  $result['result'] = 'Done.';

}

/**
  * Register a disease for a user
  * =============================
  *
  * @param  string $p_user_id
  *         The ID of the user to register a disease to.
  * @param  string $p_disease_id
  *         The ID of the disease to register.
  * @param  int $p_created_at
  *         Timestamp when the disease record was created by the user.
  * @param  int $p_start
  *         Timestamp of the beginning of the disease.
  */
function register_disease(string $p_user_id, string $p_disease_id,
                          int $p_created_at, int $p_start) : void {

  global $result;

  run_sql("", false);
  $result['result'] = 'Done.';

}

/**
  * Register a match to an event for a user
  * =======================================
  *
  * @param  string $p_user_id
  *         The ID of the user to register a match to.
  * @param  string $p_event_id
  *         The ID of the event to register to.
  * @param  int $p_created_at
  *         Timestamp when the match record was created by the user.
  * @param  string $p_device_id
  *         The ID of the device where the match was created.
  * @param  string $p_other_user_id
  *         The ID of the matching user.
  * @param  string $p_other_event_id
  *         The ID of the event created by the matching user.
  * @param  string $p_other_device_id
  *         The ID of the device where the matching user created the event.
  */
function register_match(string $p_user_id, string $p_event_id,
                        int $p_created_at, string $p_device_id,
                        string $p_other_user_id, string $p_other_event_id,
                        string $p_other_device_id) : void {

  global $result;

  run_sql("", false);
  $result['result'] = 'Done.';

}

/**
  * Register an event for a user
  * ============================
  *
  * @param  string $p_user_id
  *         The ID of the user to register an event to.
  * @param  string $p_event_id
  *         The ID of the event to register. It is a device level ID.
  * @param  int $p_created_at
  *         Timestamp when the event record was created by the user.
  * @param  string $p_device_id
  *         The ID of the device where the event was created.
  */
function register_match_event(string $p_user_id, string $p_event_id,
                          int $p_created_at, string $p_device_id) : void {

  global $result;

  run_sql("", false);
  $result['result'] = 'Done.';

}

/**
  * Register a user
  * ===============
  *
  * @param  string $p_user_id
  *         The ID of the user to register.
  */
function register_user(string $p_user_id) : void {

  global $result;

  run_sql("", false);
  $result['result'] = 'Done.';

}

/**
  * Perform SQL query
  * =================
  *
  * @param  string $p_SQL
  *         The SQL query.
  * @param  bool $p_process=True
  *         Whether or not to perform processing.
  *
  * @return array
  *         Result of the query.
  */
function run_sql(string $p_SQL, bool $p_process=True) : array {

  global $DIE_PAGE;

  global $r_page;
  global $SQL;

  $tp_conn = new mysqli($SQL['servername'], $SQL['user'], $SQL['password'],
                        $SQL['database']);
  if ($tp_conn->connect_error) {
    $r_page=$DIE_PAGE;
    return False;
  } else {
    $tp_conn->set_charset("utf8");
    if (is_array($p_SQL)) {
      foreach ($p_SQL as $tp_key => $tp_value) {
        $tp_result[$tp_key] = $tp_conn->query($tp_value);
      }
    } else {
      $tp_result = $tp_conn->query($p_SQL);
    }
    $tp_conn->close();
    if ($p_process) {
      if (is_array($tp_result)) {
        foreach ($tp_result as $tp_key => $tp_value) {
          $tp_processed[$tp_key] = $tp_value->fetch_all(MYSQLI_ASSOC);
        }
      } else {
        $tp_processed = $tp_result->fetch_all(MYSQLI_ASSOC);
      }
      return($tp_processed);
    } else {
      return $tp_result;
    }
  }

}

/**
  * Synchronize user data on a device
  * =================================
  *
  * @param  string $p_user_id
  *         The ID of the user to sync for.
  * @param  string $p_device_id
  *         The ID of the device to sync with.
  */
function sync(string $p_user_id, string $p_device_id) : void {

  global $result;

  $t_result = run_sql("");
  if (count($t_result) == 1) $result['result'] = json_encode($t_result);
  else finish_with_error('Nothing to synchronize.');

}

/**
  * Update a user record
  * ====================
  *
  * @param    string $p_user_id
  *           The ID of the user to update.
  * @param    string ?$p_nick
  *           The nickname of the user to update null, if not to update.
  * @param    int ?$p_gender_id
  *           The gender of the user to update null, if not to update.
  * @param    int ?$p_orientation
  *           The orientation of the user to update null, if not to update.
  * @param    string ?$p_photo_path
  *           Path to the photo of the user to update null, if not to update.
  */
function update_user(string $p_user_id, string ?$p_nick, int ?$p_gender_id,
                     int ?$p_orientation, string ?$p_photo_path) : void {

  global $result;

  $t_null_count = 0;
  $t_result = run_sql("");

  if (count($t_result) == 1) {

    // TODO: implement load original values.

  } else finish_with_error('Internal error by updating user.');

  if (! is_null($p_nick)) $t_sql = str_replace('%nick', $p_nick, $t_sql);
  else $t_null_count += 1;

  if (! is_null($p_gender_id))
    $t_sql = str_replace('%gender', $p_gender_id, $t_sql);
  else $t_null_count += 1;

  if (! is_null($p_orientation))
    $t_sql = str_replace('%orientation', $p_orientation, $t_sql);
  else $t_null_count += 1;

  if (! is_null($p_photo_path)) {

    // TODO: implement photo upload.

  } else $t_null_count +=1;

  if ($t_null_count == 4) finish_with_error('Nothing to update for the user.');

  run_sql($t_sql, false);
  $result['result'] = 'Done.';

}

?>
