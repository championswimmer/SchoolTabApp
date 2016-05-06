# School Tab App
An app to be installed on tabs distributed at school to disable camera and audio during school hours. 

### Badges
[![Build Status](https://travis-ci.org/championswimmer/SchoolTabApp.svg?branch=master)](https://travis-ci.org/championswimmer/SchoolTabApp) 

### Provisioning
For detailed info see - https://source.android.com/devices/tech/admin/provision.html 

#### Device Owner
Making this app device owner will make it un-uninstallable, without data wipe. Can only work on 4.3+ devices, before any account has been made.

```
usage: dpm [subcommand] [options]
usage: dpm set-device-owner <COMPONENT>
usage: dpm set-profile-owner <COMPONENT> <USER_ID>

dpm set-device-owner: Sets the given component as active admin, and its package as device owner.
dpm set-profile-owner: Sets the given component as active admin and profile owner for an existing user.
```

