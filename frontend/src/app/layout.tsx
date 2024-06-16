import './global.css';

export const metadata = {
  title: 'Book Rental',
  description: 'Book Rental Page using Next.js',
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
