public AuthResponse login(AuthRequest request) {

    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new IllegalArgumentException("Invalid credentials");
    }

    String token = jwtTokenProvider.generateToken(user.getEmail());
    return new AuthResponse(token);
}