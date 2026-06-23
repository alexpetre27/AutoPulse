"use client";

import { useState, useEffect } from "react";
import SearchInput from "./components/SearchInput";
import PostList from "./components/PostList";
import Pagination from "./components/Pagination";

export interface Post {
  id: number;
  title: string;
  body: string;
}

const POSTS_PER_PAGE = 5;

export default function App() {
  const [posts, setPosts] = useState<Post[]>([]);
  const [query, setQuery] = useState("");
  const [debouncedQuery, setDebouncedQuery] = useState("");
  const [loading, setLoading] = useState(true);
  const [currentPage, setCurrentPage] = useState(1);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((res) => res.json())
      .then((data) => {
        setPosts(data);
        setLoading(false);
      });
  }, []);

  useEffect(() => {
    const timer = setTimeout(() => {
      setDebouncedQuery(query);
      setCurrentPage(1);
    }, 400);

    return () => clearTimeout(timer);
  }, [query]);

  const filteredPosts = posts.filter((post) =>
    post.title.toLowerCase().includes(debouncedQuery.toLowerCase()),
  );

  const totalPages = Math.ceil(filteredPosts.length / POSTS_PER_PAGE);

  const paginatedPosts = filteredPosts.slice(
    (currentPage - 1) * POSTS_PER_PAGE,
    currentPage * POSTS_PER_PAGE,
  );

  return (
    <div className="container">
      <h1>Search Posts</h1>
      <SearchInput query={query} onChange={setQuery} />
      <p className="results-count">
        Showing {filteredPosts.length} of {posts.length} posts
      </p>
      <PostList posts={paginatedPosts} loading={loading} />
      {!loading && totalPages > 1 && (
        <Pagination
          currentPage={currentPage}
          totalPages={totalPages}
          onChange={setCurrentPage}
        />
      )}
    </div>
  );
}
