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
## [2025.10.25]

### Added
- Kernel and enhanced method interfaces for ColorModel component

## [2025.10.23]

### Added

- Designed a proof of concept for color model component

### Updated

- Switching project focus to color model component
- Changed design to touch variable directly
- Added inRange() and printColor() methods

## [2025.10.16]

### Added

- Designed a proof of concept for music playlist component

### Updated

- Changed design to include a hasSong() method

### Updated
- Changed toWhite() mathod from a kernel to secondary method
- Removed one of two monochromatic() method, more clarity and less redundancy having just one
## [2025.10.15]

### Added

- Designed a music playlist component
- Designed a RGB color code component
- Designed a bank account component
