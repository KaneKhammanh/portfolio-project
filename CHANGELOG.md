# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [2025.11.21]

### Added
- Kernel implementation for ColorModel1
    - no-argument constructor and constructor from 3 ints
    - standard methods clear(), newInstance(), and transferFrom()
    - kernel methods inRange(), setRed(), setGreen(), and setBlue()

### Updated
- Removed printColor() method, as it served no purpose with the presence of toString()
- private members MIN and MAX to be static and final

## [2025.10.15]

### Added

- Designed a music playlist component
- Designed a RGB color code component
- Designed a bank account component
