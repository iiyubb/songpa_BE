/** @type {import('next').NextConfig} */
const nextConfig = {
  // URL 재작성 규칙을 정의하는 함수
  async rewrites() {
    return [
        {
          source: '/api/:path*',
          destination: 'http://localhost:8080/api/path*',
      }
    ];
  },
};

export default nextConfig;
