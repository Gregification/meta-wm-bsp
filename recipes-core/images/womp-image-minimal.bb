SUMMARY = "custom image. baselined from oecore core-image-minimal. just enough to boot a device."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_OVERHEAD_FACTOR ?= "1.0"

# use STM32MP_ROOTFS_SIZE to set size, not sure why that seems to control IMAGE_ROOTFS_SIZE
STM32MP_ROOTFS_SIZE = "262144"

IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

# auto login
IMAGE_FEATURES += "empty-root-password allow-empty-password allow-root-login serial-autologin-root"
