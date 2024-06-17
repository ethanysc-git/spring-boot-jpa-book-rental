'use client';

import styles from './page.module.css';
import React, { useState, useEffect } from 'react';
import { AppUser } from '../entities/appuser';
import { Book } from '../entities/book';
import { Inventory } from '../entities/inventory';
export default function Index() {
  const [appUserRecords, setAppUserRecords] = useState<AppUser[]>([]);
  const [bookRecords, setBookRecords] = useState<Book[]>([]);
  const [inventoryRecords, setInventoryRecords] = useState<Inventory[]>([]);
  const [loginRole, setLoginRole] = useState<AppUser>({
    id: '',
    password: '',
    role: 'GUEST',
    username: '',
  });

  const login = (e: string) => {
    const pText = e;
    if (pText == 'USER') {
      const appUser = appUserRecords.filter(
        (user: AppUser) => user.role == 'USER'
      )[0];
      setLoginRole(appUser);
    } else if (pText == 'ADMIN') {
      const appUser = appUserRecords.filter(
        (user: AppUser) => user.role == 'ADMIN'
      )[0];
      setLoginRole(appUser);
    } else {
      setLoginRole({
        id: '',
        password: '',
        role: 'GUEST',
        username: '',
      });
    }
  };

  const borrowBook = async (e: Book) => {
    if (e.availableRecord.length == 0) {
      return;
    }
    if (loginRole.role == 'GUEST') {
      alert('Login First');
    } else {
      const inventoryId = e.availableRecord[0].id;
      await fetch(`http://localhost:8080/books/borrow`, {
        method: 'PUT',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({
          id: inventoryId,
          book_id: e.id,
          user_id: loginRole.id,
          loan_date: '',
        }),
      }).then((response) => {
        if (response.status == 200) {
          return response.json();
        }
        return null;
      });
    }
  };

  const returnBook = async (e: Book) => {
    if (e.borrowedRecord.length == 0) {
      return;
    }
    if (loginRole.role == 'GUEST') {
      alert('Login First');
    } else {
      const inventoryId = e.borrowedRecord[0].id;
      await fetch(`http://localhost:8080/books/return`, {
        method: 'PUT',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({
          id: inventoryId,
          book_id: e.id,
          user_id: loginRole.id,
          loan_date: '',
        }),
      }).then((response) => {
        if (response.status == 200) {
          return response.json();
        }
        return null;
      });
    }
  };

  useEffect(() => {
    if (appUserRecords.length === 0) {
      const fetchData = async () => {
        await fetch('http://localhost:8080/user/records', {
          method: 'GET',
        })
          .then((response) => {
            if (response.status == 200) {
              return response.json();
            }
            return null;
          })
          .then((data) => {
            if (data !== null) {
              setAppUserRecords(data);
            }
          });
      };
      fetchData();
    }
  }, [appUserRecords]);

  useEffect(() => {
    if (bookRecords.length === 0) {
      const fetchData = async () => {
        await fetch('http://localhost:8080/books/', {
          method: 'GET',
        })
          .then((response) => {
            if (response.status == 200) {
              return response.json();
            }
            return null;
          })
          .then((data) => {
            if (data !== null) {
              setBookRecords(data);
            }
          });
      };
      fetchData();
    }
  }, [bookRecords, loginRole]);

  useEffect(() => {
    if (bookRecords.length > 0) {
      const fetchData = async () => {
        await fetch('http://localhost:8080/inventory/', {
          method: 'GET',
        })
          .then((response) => {
            if (response.status == 200) {
              return response.json();
            }
            return null;
          })
          .then((data) => {
            if (data !== null) {
              bookRecords.forEach((book: Book) => {
                const available_res = data.filter(
                  (i: Inventory) => book.id == i.book_id && i.loan_date == null
                );
                const borrowed_res = data.filter(
                  (i: Inventory) =>
                    book.id == i.book_id &&
                    i.loan_date != null &&
                    i.user_id == loginRole.id
                );
                book.availableRecord = available_res;
                book.borrowedRecord = borrowed_res;
                book.availableBalance = available_res.length;
                book.borrowedAmount = borrowed_res.length;
              });
              setInventoryRecords(data);
            }
          });
      };
      fetchData();
    }
  }, [bookRecords, inventoryRecords]);

  /*

   */
  return (
    <div className={styles.page}>
      <div className="wrapper">
        <div className="container">
          <div id="welcome">
            <h1>Welcome Book Rental 👋</h1>
            <a id="user-login" className="button-pill rounded shadow">
              <svg
                viewBox="0 0 24 24"
                stroke="#212b36"
                fill="currentColor"
                role="img"
                xmlns="http://www.w3.org/2000/svg"
              >
                <circle cx="12" cy="8" r="5" />
                <path d="M3,21 h18 C 21,12 3,12 3,21" />
              </svg>
              <p>-{loginRole.role}</p>
              <div className="dropdown-content">
                <p onClick={(e) => login((e.target as HTMLElement).innerText)}>
                  USER
                </p>
                <p onClick={(e) => login((e.target as HTMLElement).innerText)}>
                  ADMIN
                </p>
                <p onClick={(e) => login((e.target as HTMLElement).innerText)}>
                  Logout
                </p>
              </div>
            </a>
          </div>
          <div id="hero" className="rounded">
            {
              <>
                {bookRecords.map((record) => (
                  <div key={record.id} className="text-container">
                    <div className="container-left">
                      <h2>
                        <svg
                          fill="none"
                          stroke="currentColor"
                          viewBox="0 0 24 24"
                          xmlns="http://www.w3.org/2000/svg"
                        >
                          <path
                            strokeLinecap="round"
                            strokeLinejoin="round"
                            strokeWidth="2"
                            d="M9 12l2 2 4-4M7.835 4.697a3.42 3.42 0 001.946-.806 3.42 3.42 0 014.438 0 3.42 3.42 0 001.946.806 3.42 3.42 0 013.138 3.138 3.42 3.42 0 00.806 1.946 3.42 3.42 0 010 4.438 3.42 3.42 0 00-.806 1.946 3.42 3.42 0 01-3.138 3.138 3.42 3.42 0 00-1.946.806 3.42 3.42 0 01-4.438 0 3.42 3.42 0 00-1.946-.806 3.42 3.42 0 01-3.138-3.138 3.42 3.42 0 00-.806-1.946 3.42 3.42 0 010-4.438 3.42 3.42 0 00.806-1.946 3.42 3.42 0 013.138-3.138z"
                          />
                        </svg>
                        <span>{record.title}</span>
                      </h2>
                    </div>
                    <div className="container-right">
                      <span></span>

                      {record.borrowedAmount > 0 && (
                        <a onClick={(e) => returnBook(record)}>Return</a>
                      )}
                      {record.borrowedAmount > 0 && (
                        <p>{record.borrowedAmount} : </p>
                      )}

                      {record.availableBalance > 0 && (
                        <a onClick={(e) => borrowBook(record)}>Borrow</a>
                      )}
                      {record.availableBalance > 0 && (
                        <p>{record.availableBalance} : </p>
                      )}
                    </div>
                  </div>
                ))}
              </>
            }
          </div>
          <div id="middle-content">
            <div id="inventory-list">
              {
                <>
                  {bookRecords.map((record) => (
                    <div
                      key={record.id}
                      className="inventory-item rounded shadow"
                    >
                      <div>
                        <svg
                          width="120"
                          height="120"
                          xmlns="http://www.w3.org/2000/svg"
                        >
                          <image href={record.image} height="120" width="120" />
                        </svg>
                        <h2>
                          Author
                          <span>{record.author}</span>
                        </h2>
                      </div>
                      <p>{record.title}</p>
                    </div>
                  ))}
                </>
              }
            </div>
          </div>
          <div id="commands" className="rounded shadow">
            <h2>GitHub Repo</h2>
            <details>
              <summary>
                <svg
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="M8 9l3 3-3 3m5 0h3M5 20h14a2 2 0 002-2V6a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                  />
                </svg>
                Backend
              </summary>
              <pre>
                <a
                  href="https://github.com/ethanysc-git/spring-boot-jpa-book-rental/tree/main/backend"
                  target="_blank"
                  rel="noreferrer"
                >
                  <span># spring-boot-jpa-book-rental/backend/</span>
                </a>
              </pre>
            </details>
            <details>
              <summary>
                <svg
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="M8 9l3 3-3 3m5 0h3M5 20h14a2 2 0 002-2V6a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                  />
                </svg>
                Frontend
              </summary>
              <pre>
                <a
                  href="https://github.com/ethanysc-git/spring-boot-jpa-book-rental/tree/main/backend"
                  target="_blank"
                  rel="noreferrer"
                >
                  <span># spring-boot-jpa-book-rental/frontend/</span>
                </a>
              </pre>
            </details>
            <a
              id="app-repo"
              className="button-pill rounded shadow"
              href="https://github.com/ethanysc-git/spring-boot-jpa-book-rental/tree/main"
              target="_blank"
              rel="noreferrer"
            >
              <svg
                fill="currentColor"
                role="img"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M12 .297c-6.63 0-12 5.373-12 12 0 5.303 3.438 9.8 8.205 11.385.6.113.82-.258.82-.577 0-.285-.01-1.04-.015-2.04-3.338.724-4.042-1.61-4.042-1.61C4.422 18.07 3.633 17.7 3.633 17.7c-1.087-.744.084-.729.084-.729 1.205.084 1.838 1.236 1.838 1.236 1.07 1.835 2.809 1.305 3.495.998.108-.776.417-1.305.76-1.605-2.665-.3-5.466-1.332-5.466-5.93 0-1.31.465-2.38 1.235-3.22-.135-.303-.54-1.523.105-3.176 0 0 1.005-.322 3.3 1.23.96-.267 1.98-.399 3-.405 1.02.006 2.04.138 3 .405 2.28-1.552 3.285-1.23 3.285-1.23.645 1.653.24 2.873.12 3.176.765.84 1.23 1.91 1.23 3.22 0 4.61-2.805 5.625-5.475 5.92.42.36.81 1.096.81 2.22 0 1.606-.015 2.896-.015 3.286 0 .315.21.69.825.57C20.565 22.092 24 17.592 24 12.297c0-6.627-5.373-12-12-12" />
              </svg>
              <span>Ethan Chen</span>
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}
