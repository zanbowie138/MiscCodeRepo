float fwd = (R + L)/2
theta = IMU
relX = fwd
relY = strafe

// Watch if d_theta = 0
r0 = d_fwd / d_theta
r1 = d_str / d_theta
  
d_relX = r0*sin(d_theta) - r1 * (1-cos(d_theta))
d_relY = r1*sin(d_theta) + r0 * (1-cos(d_theta))
  
x += d_relX * cos(theta) - d_relY * sin(theta)
y += d_relY * cos(theta) + d_relX * sin(theta)
