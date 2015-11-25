# GReza
A GRUB theme.

Find out the resolution grub supports:
- `hwinfo --framebuffer`
- At grub commandline (pressing `C` at grub menu): `vbeinfo`

To name an icon for display in the grub menu, you need to know the distro class name.
`menuentry "Gentoo" --class **gentoo** --class os...`
